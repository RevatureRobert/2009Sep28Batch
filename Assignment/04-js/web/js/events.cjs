console.log("js file is connected"); //good practice to make sure that your js file is getting found. 


function hey(){
    console.log("hey");
}

/**
 * 
 * @param eventObj {the event obj}
 * 
 * we can gather information about what happened and the 
 * state of the page from the event object. the event object will 
 * be passed in and will have several properties that can give you insight 
 * into what was happening when that event was triggered. 
 * 
 */

function printTheEventObject(eventObj){
    console.log(eventObj.clientX);
    console.log(eventObj.clientY);
}