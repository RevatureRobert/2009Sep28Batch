let seaballerList = [
  {
    "id": 1,
    "name": "Squibby",
    "stats": {
      "species": "seal",
      "position": "goalie",
      "rep": 20
    }
  },
  {
    "id": 2,
    "name": "Lippy",
    "stats": {
      "species": "red-lipped batfish",
      "position": "flipper",
      "rep": 15
    }
  },
  {
    "id": 3,
    "name": "Vlad",
    "stats": {
      "species": "vampire squid",
      "position": "forward",
      "rep": 85
    }
  }
];

const seaballers = [];

const dataurl = "http://localhost:52330/mockdata.json";

function printCards(list){  
  for (let sb of list){
    const nameLi = document.createElement("li");
    const speciesLi = document.createElement("li");
    const positionLi = document.createElement("li");
    const repLi = document.createElement("li");

    nameLi.append(`Name: ${sb.name}` );
    speciesLi.append(`Species: ${sb.stats.species}`);
    positionLi.append(`Position: ${sb.stats.position}`);
    repLi.append(`Rep Points: ${sb.stats.rep}`);

    document.getElementById("ballers").append(nameLi);
    document.getElementById("ballers").append(speciesLi);
    document.getElementById("ballers").append(positionLi);
    document.getElementById("ballers").append(repLi);
  }
}


fetch("http://localhost:52330/mockdata.json", {
  method: "get",
  mode: "no-cors"
})
  .then((r) => r.json())
  .then((sb) => printCards(sb));
