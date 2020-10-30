/*
    AJAX
        Asynchronous JavaScript and XML

    CORS sends an options request as a handshake before it actually sends a get request; checks if it can send that request
*/

function ajaxGetRequest(url, expression, method = "get"){
    //step 1
    const xhr = new XMLHttpRequest();

    //step 2
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200){
            /*  readyState: 
                    0 request uninitialized
                    1 request initialized / connection established
                    2 request received
                    3 server is processing request
                    4 request finished processing and response is ready
                status:
                    100 info
                    200 ok
                    300 redirect
                    400 client-side err
                    500 server-side err
            */

            const jsonResponse = JSON.parse(); // turn a string into an object
            // JSON.stringify() --> torn an object into a string

            expression(jsonResponse);
        }
    };

    //step 3
    xhr.open(method, url); // request to url-pattern

    //step 4
    xhr.send();


}


// preferred method of writing this function, using promises
// use this for project 1
function fetchGetRequest(url) {
    return fetch(url)
        .then(response => response.json())
        .then(result => result);
}

async function asyncFetch(url, expression) {
    const response = await fetch (url);
    const json = await response.json();
    expression(json); // don't try to return with this operation; you will be waiting
}// async functions must change the way you program ...