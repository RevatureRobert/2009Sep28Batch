


class Player {
    constructor() {
        this.hp = 30;
        this.weapon = new Weapon("fist", 5);
    }

    heal() {
        hp += 5;
    }
    attack(enemy) {
        enemy.hp -= this.weapon.damage;
    }

}
class Enemy {
    constructor() {
        this.hp = 20;
        this.damage = 3;
    }
    attack(player) {
        player.hp -= this.damage;
    }
}

class Weapon {
    constructor(name, damage) {
        this.name = name;
        this.damage = damage;
    }
}

const spaces = new Array(5);
const enemies = []
const player1 = new Player();
let currentEnemy;
let inBattle = false;

for (let i = 0; i < 5; i++) {
    spaces[i] = new Array(5);
}

let currentX = 2;
let currentY = 2;
function createMap() {
    let i;
    let j;
    for (i = 0; i < 5; i++) {

        for (j = 0; j < 5; j++) {
            enemies[i] = [];
            if (((i == 0 || i == 4) && j == 2) || (i == 2 && (j == 0 || j == 4))) {
                enemies[i][j] = new Enemy();
                if (typeof spaces[i][j] == 'undefined') {
                    spaces[i][j] = 'R';
                }

                continue;
            }
            if (typeof spaces[i][j] == 'undefined') {
                spaces[i][j] = 'X';
            }

        }
    }
    spaces[currentY][currentX] = "P";
    updateMap();
}
function updateMap() {
    document.getElementById("tablebody").innerHTML = "";
    for (let i = 0; i < 5; i++) {
        const tr = document.createElement("tr");
        for (let j = 0; j < 5; j++) {
            const tD = document.createElement("td");
            tD.innerText = spaces[i][j];
            tr.append(tD);
        }
        document.getElementById("tablebody").append(tr);
    }
    colorMap();
}

function colorMap() {
    let table = document.getElementById("tablebody");
    let tableData = table.getElementsByTagName("td");
    for (b of tableData) {
        if (b.innerHTML === "P") {
            b.style = "background-color: MidnightBlue;";
        } else if (b.innerHTML === "R") {
            b.style = "background-color: DarkRed;";
        } else {
            b.style = "background-color: #1f1f1f;";
        }
    }
}



function isRoom() {
    return ((currentX == 0 || currentX == 4) && currentY == 2) || (currentX == 2 && (currentY == 0 || currentY == 4))
}

function up() {
    if (currentY != 0 && !inBattle) {
        if (isRoom()) {
            spaces[currentY][currentX] = 'S';
        } else {
            spaces[currentY][currentX] = 'O';
        }
        spaces[--currentY][currentX] = 'P';
    } else {
        console.log("Invalid Direction!");
    }
    updateMap();
    battle();
}

function down() {
    if (currentY != 4 && !inBattle) {
        if (isRoom()) {
            spaces[currentY][currentX] = 'S';
        }
        else {
            spaces[currentY][currentX] = 'O';
        }
        spaces[++currentY][currentX] = 'P';
    } else {
        console.log("Invalid Direction!");
    }
    updateMap();
    battle();
}

function left() {
    if (currentX != 0 && !inBattle) {
        if (isRoom()) {
            spaces[currentY][currentX] = 'S';
        }
        else {
            spaces[currentY][currentX] = 'O';
        }
        spaces[currentY][--currentX] = 'P';
    } else {
        console.log("Invalid Direction!");
    }
    updateMap();
    battle();
}

function right() {
    if (currentX != 4 && !inBattle) {
        if (isRoom())
            spaces[currentY][currentX] = 'S';
        else {
            spaces[currentY][currentX] = 'O';
        }
        spaces[currentY][++currentX] = 'P';
    } else {
        console.log("Invalid Direction!");
    }
    updateMap();
    battle();
}

function attack() {
    const log = document.getElementById("log");
    if (inBattle) {
        player1.attack(currentEnemy);
        currentEnemy.attack(player1);

        log.innerHTML = "Player Health: " + player1.hp + " Enemy Health:" + currentEnemy.hp;
        console.log(currentEnemy.hp);
        console.log(player1.hp);
        if (player1.hp <= 0 || currentEnemy.hp <= 0) {
            inBattle = false;
        }
    }
}

function heal() {
    if (inBattle) {
        player1.heal();
        if (player1.hp <= 0 || currentEnemy.hp <= 0) {
            inBattle = false;
        }
    }
}

function battle() {
    currentEnemy = enemies[currentY][currentX];
    if (isRoom() && currentEnemy) {
        if (currentEnemy.hp > 0) {
            inBattle = true;
        }
    }
}


