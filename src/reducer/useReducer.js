export const initialState = {
    user : null,
    userId : 0,
    isExpired : 0,
    token : ""
}

export const reducer = (state=initialState,action) => {
    if(action.type === "USER"){
        return {...state,user : action.payload}
    }
    if(action.type === "USER_ID"){
        return {...state,userId : action.payload}
    }
    return state
}