function renderTable(monsters) {
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
  }
}

async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}

asyncFetch("http://localhost:8080/HallowsMonsters/all.json", renderTable);

async function addMonster() {
  const monster = {
    name: document.getElementById("monName").value,
    type: {
      type: document.getElementById("monType").value,
      furry: document.getElementById("monFur").value,
      paws: document.getElementById("monPaws").value,
    },
  };
  const fetched = await fetch("http://localhost:8080/HallowsMonsters/monster.json", {
    method: "post",
    body: JSON.stringify(monster),
  });
  const json = await fetched.text();
  const rows = document.getElementById('hallowsTableBody').innerHTML='';
  asyncFetch("http://localhost:8080/HallowsMonsters/all.json", renderTable);
}

document.getElementById("monSubmit").addEventListener("click", addMonster);
