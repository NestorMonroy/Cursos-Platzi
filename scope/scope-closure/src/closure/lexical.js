//el ambito lexico son las funciones que se ejecutan ulizando
//la cadena del alcance donde estaba vigente en en su momento
//es decir que se tiene el valor de count que esta declarado en la funcion principal
//pero esta accecible dentro de siguiente funcion

//https://www.youtube.com/watch?v=JXG_gQ0OF74

const buildCount = (i) => {
  let count = i;
  //se genera el closure
  const displayCount = () => {
    console.log(count++);
  };
  return displayCount;
};

const myCount = buildCount(1);
myCount();
myCount();
myCount();

//aqui tenemos un nuevo closure, un nuevo alcance, un nuevo ambito
const myOtherCount = buildCount(10);
myOtherCount();
myOtherCount();
