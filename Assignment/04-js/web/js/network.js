/*
    AJAX
        what does it stand for?
            Asynchronous Javascript and XML
*/

function ajaxGetRequest(url,expression, method = "get"){
    //step 1
    const xhr = new XMLHttpRequest(); //can send html requests and gather responses

    //step2
    xhr.onreadystatechange = () => {
        if(xhr.readyState == 4 && xhr.status === 200){
            /*
               status codes
                    100(informational), 200(ok), 300(redirect),400(client side error), 500(server side error).  

                ready state
                    0 = request has not been initialized
                    1 = request has been initialized (connection has been established)
                    2 = request has been received
                    3 = server is processing the request
                    4 = request has finished processing and the response is ready. 
                    
            */

            //use json.parse to create a javascript object
            //use json.stringify to create a json string, use this to send json requests. 
            const jsonResponse = JSON.parse(xhr.responseText); 

            expression(jsonResponse);
        }
    }

    //step 3
    xhr.open(method,url);

    //you can attach headers and stuff like that between step 3 and 4. 
    //step 4
    xhr.send();
}


function fetchGetRequest(url){
    return fetch(url).then(response => response.json()).then(result => result);
}

//async marks a function as asynchronous. JS is synchronous. 
//don't use returns with async. 
async function asyncFetch(url, expression){
    const response = await fetch(url);
    const json = await response.json;
    expression(json);
}