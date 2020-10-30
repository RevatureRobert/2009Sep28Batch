function renderTable(monsters) { // appends all monsters to the HTML document's table
  for (const monster of monsters) {
    const tr = document.createElement("tr");
    const nameTd = document.createElement("td");
    const typeTD = document.createElement("td");
    const furryTd = document.createElement("td");
    const pawsTd = document.createElement("td");

    nameTd.innerText = monster.name;
    typeTD.innerText = monster.type.type;
    furryTd.innerText = monster.type.furry;
    pawsTd.innerText = monster.type.paws;

    tr.append(nameTd, typeTD, furryTd, pawsTd);
    // tr.append(typeTD);
    // tr.append(furryTd);
    // tr.append(pawsTd);
    document.getElementById("hallowsTableBody").append(tr);
  };
};


async function asyncFetch(url, expression){
	const response = await fetch(url); // pushes the input url to the server and promises a response from it
	const json = await response.json(); // reads the response's json attribute into the "json" variable
	expression(json); // passes the json into a function "expresson" to be used as an JavaScript object
}

asyncFetch(
	"http://localhost:8080/HallowsMonsters/all.json", // awaits a json response using this url
	renderTable // passes the json response into the renderTable function as a JavaScript object
);



async function addMonster(){
	const monster = { // get monster data from the HTML document
		name: document.getElementById('monName').value,
		type:{
			type: document.getElementById('monType').value,
			furry: document.getElementById('monFur').value,
			paws: document.getElementById('monPaws').value
		}
	};
	// pushes the input url using doPost, with the monster data as a string
	const fetched = await fetch("http://localhost:8080/HallowsMonsters/monster.json", {
		method:	'post',
		body:	JSON.stringify(monster)
	});
	// json = fetched response string, rows = row elements in HTML document
	const json = await fetched.text();
	const rows = document.getElementById('hallowsTableBody').childNodes;
	
	asyncFetch(// re-fetches all the monsters and rer-renders the table
		"http://localhost:8080/HallowsMonsters/all.json",
		renderTable
	);
};
// monSubmit button now runs the addMonster function on click events
document.getElementById('monSubmit').addEventListener('click', addMonster);