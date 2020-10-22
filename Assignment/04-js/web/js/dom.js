/*
    what does dom stand for?
        document object model 
        dom is the html document
        object representation of the html. 
        it also is associated with other markup languages like xml. 
    window object
        this holds everything that we create, methods in js files and html document.
        so dom is a property of the window object. 
*/

/*
    We have three categories for manipulating the dom
        finding elements
            document.getElementsByTagName(tagName)
            document.getElementsByClassName(className)
            document.getElementById(id) //will return the first element with the id
        changing elements
            element.innerText=value
            element.attribute = value
            element.setAttribute(attribute,value)
            element.style.property = value
        adding and removing elements
            document.write(text)
            document.createElement(tagName)
            element.appendChild(element)
            element.removeChild(element)
            element.replaceChild(element)
*/

const buttons = document.getElementsByTagName("button");
console.log(buttons);
//this shouldn't work because the script gets called in the header before the button is created. 
buttons[0].innerHTML = "change";
const para = document.createElement('p');
para.innerText = 'hey this was kinda cool';
document.body.append(para);


const mockedMonsters = [
    {
        name: 'demi',
        type: {
            type: 'werewolf',
            furry: 'true',
            paws: 'true'
        },
    },
    {
        name: 'casper',
        type: {
            type: 'ghost',
            furry: 'false',
            paws: 'false'
        },
    },
    {
        name: 'revawolf',
        type: {
            type: 'werewolf',
            furry: 'true',
            paws: 'true'
        },
    }

];
function renderTable(monsters) {
    for (const monster of mockedMonsters) {
        const tr = document.createElement('tr');
        const nameTd = document.createElement('td');
        const typeTd = document.createElement('td');
        const furryTd = document.createElement('td');
        const pawsTd = document.createElement('td');
        nameTd.innerText = monster.name;
        typeTd.innerText = monster.type.type;
        furryTd.innerText = monster.type.furry;
        pawsTd.innerText = monster.type.paws;
        // tr.append(nameTd);
        // tr.append(typeTd);
        // tr.append(furryTd);
        // tr.append(pawsTd);
        tr.append(nameTd, typeTd, furryTd, pawsTd);
        //this doesn't work yet for some reason. 
        // tr.append(document.createElement('td').setAttribute('innerText',monster.name));
        // tr.append(document.createElement('td').setAttribute('innerText',monster.type));
        // tr.append(document.createElement('td').setAttribute('innerText',monster.furry));
        // tr.append(document.createElement('td').setAttribute('innerText',monster.paws));


        document.getElementById("hallowsTableBody").append(tr);
    }
}
//renderTable(mockedMonsters);
//ajaxGetRequest("http://localhost:8080/HallowsMonsters/all.json",renderTable,"get");
fetch('http://localhost:8080/HallowsMonsters/all.json', {
    body: JSON.stringify(mockedMonsters),
    method: 'post',
    mode: "no-cors",
    headers: {
        origin:'localhost'
    }
}).then(r => r.json()).then(mockedMonsters.push);