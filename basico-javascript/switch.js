var player1 = "Ganaste";
var player2 = "Te ganaron";
var rock = "Piedra";
var paper = "Papel";
var scissors = "Tijera";

function game(player1, player2) {
  switch (true) {
    case player1 === player2:
      console.log("Que lindo empate");
      break;
    case player1 === paper && player2 === rock:
      console.log("Papel, gana jugador 1");
      break;
    case player1 === paper && player2 === scissors:
      console.log("Tijera, gana jugador 2");
      break;
    case player1 === rock && player2 === paper:
      console.log("Papel, gana jugador 2");
      break;
    case player1 === rock && player2 === scissors:
      console.log("Piedra, gana jugador 1");
      break;
    case player1 === scissors && player2 === paper:
      console.log("Tijera, gana jugador 1");
      break;
    case player1 === scissors && player2 === rock:
      console.log("Piedra, gana jugador 2");
      break;
    default:
      console.log("¿No juegan?");
  }
}


game(paper, scissors)
