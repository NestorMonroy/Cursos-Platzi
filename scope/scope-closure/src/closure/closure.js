//un closure recuerda el ambito donde ha sido creado
// const moneyBox = (coins) =>{
//     var saveCoins = 0;
//     saveCoins += coins;
//     console.log(`Money box: $${saveCoins}`)
// }
// //No funciona

// moneyBox(5);
// moneyBox(10);

const moneyBox = () => {
  debugger
  var saveCoins = 0;
  const countCoins = (coins) => {
    debugger
    saveCoins += coins;
    console.log(`MoneyBox: $${saveCoins}`);
  };
  return countCoins;
};

let myMoneyBox = moneyBox();
myMoneyBox(5);
myMoneyBox(10);
