/*
    What does dom stand for?
        document object model - object representation of the html
            there is also a dom for xml, may also be so for any markup language
        the html page is an object called "document"
        can access the document object usint the dot operator
            document.body selects the body
            document.head.title
        document is in global scope...
    "window" is the true parent of all in the document, including the js and the document
        document is the window.document field
        everything put in the global scope is actually added to the window object
        has functions outside of the document
            window.history.back & window.history.forward associated with what you'd think
*/

/*
    three categories for manipulating the dom
        finding elements
            document.getElementsByTagName('h1') -- returns an array of h1 elements
            document.getElementsByClass('myClass') -- returns an array of elements with the class attribute 'myClass'
            document.getElementById('bang') -- returns the first element with the id attribute 'bang'
        changing elements
            element.innerText = value
            element.attribute = value
            element.setAttribute(attribute, value)
            element.innerHTML = value
            element.style.property = value
        adding & removing elements
            document.write('text') -- first call erases everything and writes 'text'; subsequent calls append more 'text' strings
            document.createElement(tagname)
            element.append(... elements)
            element.appendChild(element)
            element.removeChild(element)
            element.replaceChild(element)
*/

const buttons = document.getElementsByTagName("button");
console.log(buttons);

buttons[0].innerHTML = 'sfg';

const para = document.createElement('p');
para.innerText = 'hey this is kinda cool';

// append and appendChild are different in a few ways ...
document.body.append(para);

const mockedMonsters = [
    {
        name: "demi",
        type: {
            type: "werewolf",
            furry: "true",
            paws: "true"
        }
    },
    {
        name: "casper",
        type: {
            type: "werewolf",
            furry: "true",
            paws: "true"
        }
    },
    {
        name: "revi",
        type: {
            type: "werewolf",
            furry: "true",
            paws: "true"
        }
    }
];

function renderTable(monsters){
    for(const monster of mockedMonsters){
        const tr = document.createElement('tr');
        const nameTd = document.createElement('td');
        const typeTd = document.createElement('td');
        const furryTd = document.createElement('td');
        const pawsTd = document.createElement('td');
        
        nameTd.innerText = monster.name;
        typeTd.innerText = monster.type.type;
        furryTd.innerText = monster.type.furry;
        pawsTd.innerText = monster.type.paws;

        tr.append(nameTd, typeTd, furryTd, pawsTd);
        //tr.append(typeTd);
        //tr.append(furryTd);
        //tr.append(pawsTd);

        document.getElementById("hallowsTableBody").append(tr);
    }
}

// renderTable(mockedMonsters);
// ajaxGetRequest(
//     "http://localhost:8080/HallowsMonsters/all.json",
//     renderTable,
//     "get"
// );

fetch('http://localhost:8080/HallowsMonsters/all.json',{
    body: JSON.stringify(mockedMonsters),
    method: 'get',
    mode: "no-cors", // not necessarily relevant; this is browser extension functionality
    headers: {
        origin: 'localhost'
    }
})
    .then((r) => r.json())
    .then(mockedMonsters.push);

// ASSIGN: try a couple things with DOM manipulation
// create 5 buttons on HTML
//  Left, Right, Up, Down, Attack, Heal
//  Recreate the DEBUG ME game