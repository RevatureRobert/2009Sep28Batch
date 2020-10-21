/* 
  AJAX
    what does it stand for?
      Asynchronous Javascript and XML
*/

function ajaxGetRequest(url, expression, method = "get") {
  //step 1
  const xhr = new XMLHttpRequest();

  //step 2
  xhr.onreadystatechange = () => {
    if (xhr.readyState === 4 && xhr.status === 200) {
      /* 
        status code
          100 = informational
          200 = ok
          300 = redirect
          400 = client side error
          500 = server side error
        
        ready state
          0 = request has not been initialized
          1 = request has been initialized (the connection has been established)
          2 = request has been received
          3 = server is processing the request
          4 = request has finished processing and the response is ready
      */

      const jsonResponse = JSON.parse(xhr.responseText);

      expression(jsonResponse);
    }
  };

  //step 3
  xhr.open(method, url);

  //step 4
  xhr.send();
}

function fetchGetRequest(url) {
  return fetch(url)
    .then((response) => response.json())
    .then((result) => result);
}

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}
