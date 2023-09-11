import axios from "axios";
import { toast } from 'react-toastify';
import environment from "./environment";

export const ApiCall = async (path, pdata=null,params=null,header=null) => {
    let response = null;
    try {
        const notify = (message,type) => {
            if(type == "success")
                toast.success(message);
            else
                toast.error(message);
        }
    
        var url = environment.REACT_APP_API_URL + path;
        var token = localStorage.getItem("token");

        const headers = {
            "Content-Type": header?header:"application/json",
            Authorization: `Bearer ${token}`,
        };

        if (pdata) response = await axios.post(url, pdata, { cache: 'no-cache',mode: 'no-cors',headers: headers });
        else response = await axios.get(url, {mode: 'no-cors', headers: headers ,params});

        const rdata = response.data;

        if (pdata) {
            if (rdata.status == 200) {
                notify(rdata.message,"success")
                return rdata
            } else {
                notify(rdata.message,"error")
                return rdata
            }
        } else {
            if (rdata.status == 200) {
                return rdata
            } else {
                return rdata
            }
        }
    } catch (err) {
        if (err && (err.response.data.status === 401 || err.response.data.status === 429)) {
            localStorage.clear();
            window.location.href = window.location.origin
        }
    }
};

export const deleteAPICall = async (path) => {
    let response = null;
    try {
        const notify = (message,type) => {
            if(type == "success")
                toast.success(message);
            else
                toast.error(message);
        }

        var token = localStorage.getItem("token");
        var url = environment.REACT_APP_API_URL + path;

        const headers = {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
        };

        response = await axios.delete(url, { cache: 'no-cache',mode: 'no-cors',headers: headers});

        const rdata = response.data;

        if (rdata.status == 200) {
            notify(rdata.message,"success")
            return rdata
        } else {
            notify(rdata.message,"error")
            return rdata
        }

    } catch (err) {
        if (err && (err.response.data.status === 401 || err.response.data.status === 429)) {
            localStorage.clear();
            window.location.href = window.location.origin
        }
    }
}

// export const postRequest = async (path, data) => {
//   let response = null;
//   try {
//     const notify = (message,type) => {
//       if(type == "success")
//         toast.success(message);
//       else
//         toast.error(message);
//     }

//     var url = environment.REACT_APP_API_URL + path;
//     var token = localStorage.getItem("token");
//     const headers = {
//       "Content-Type": "application/json",
//       Authorization: `Bearer ${token}`,
//     };

//     response = await axios.post(url, data, { cache: 'no-cache',mode: 'no-cors',headers: headers });
//     const rdata = response.data;
//     if (rdata.statusCode == 200) {
//       return rdata
//     } else {
//       if(typeof rdata.message === "object") {
//         for (var key in rdata.message) {
//           if (rdata.message.hasOwnProperty(key)) {
//             notify(rdata.message[key][0],"error")
//           }
//         }
//       } else {
//         notify(rdata.message,"error")
//       }
//       return rdata
//     }
//   } catch (err) {
//     if (err && (err.response.data.statusCode === 401 || err.response.data.statusCode === 429)) {
//       localStorage.clear();
//       window.location.href = window.location.origin
//     }
//   }
// }

// export const dateConverter =  (date) => {
//   return moment.utc(date).local().format("MM-DD-YYYY")
// };
