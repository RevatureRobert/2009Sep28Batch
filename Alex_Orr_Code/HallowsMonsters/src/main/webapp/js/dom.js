
function renderTable(monsters){
for (const monster of mockedMonsters){
    const tr = document.createElement('tr');
    const nameTd = document.createElement('td');
    const typeTd = document.createElement('td');
    const furryTd = document.createElement('td');
    const pawsTd = document.createElement('td');

    nameTd.innerText = monster.name;
    typeTd.innerText = monster.type.type;
    furryTd.innerText = monster.type.furry;
    pawsTd.innerText = monster.type.paws;

    tr.append(nameTd);
    tr.append(typeTd);
    tr.append(furryTd);
    tr.append(pawsTd);

    document.getElementById("hallowsTableBody").append(tr);
}
}
//even better way
async function asyncFetch(url, expression) {
    const response = await fetch(url);
    const json = await response.json();
    expression(json);
}