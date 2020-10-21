/* 
  what does dom stand for?
      document object model
      object representation of the html
*/

/* 
  We have three categories for manipulating the dom
    finding elements
      document.getElementsByTagName(tagName)
      document.getElementsByClassName(className)
      document.getElementById(id)
    changing elements
      element.innerText = value
      element.attribute = value
      element.setAttribute(attribute, value)
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
buttons[0].innerHTML = "sfgheg";
const para = document.createElement("p");
para.innerText = "hey this was kinda cool";
document.body.append(para); //append and appendChild are different in a few ways, this is left for you to discover

const mockedMonsters = [
  {
    name: "demi",
    type: "werewolf",
    furry: "true",
    paws: "true",
  },
  {
    name: "casper",
    type: "ghost",
    furry: "false",
    paws: "false",
  },
  {
    name: "revawolf",
    type: "werewolf",
    furry: "true",
    paws: "true",
  },
];

for (const monster of mockedMonsters) {
  const tr = document.createElement("tr");
  const nameTd = document.createElement("td");
  const typeTD = document.createElement("td");
  const furryTd = document.createElement("td");
  const pawsTd = document.createElement("td");
  nameTd.innerText = monster.name;
  typeTD.innerText = monster.type;
  furryTd.innerText = monster.furry;
  pawsTd.innerText = monster.paws;
  tr.append(nameTd, typeTD, furryTd, pawsTd);
  // tr.append(typeTD);
  // tr.append(furryTd);
  // tr.append(pawsTd);
  document.getElementById("hallowsTableBody").append(tr);
}
