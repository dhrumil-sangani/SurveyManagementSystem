export const initialState = {
    user : null,
    userName : "",
    isExpired : 0,
    token : ""
}

export const reducer = (state=initialState,action) => {
    if(action.type === "USER"){
        return {...state,user : action.payload}
    }
    if(action.type === "USERNAME"){
        return {...state,userName : action.payload}
    }
    return state
}