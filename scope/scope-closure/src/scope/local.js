const helloWorld = () => {
  const hello = "Hello world";
  console.log(hello);
};

helloWorld();
console.log(hello);

var scope = 'i am global '

const functionScope = () => {
  var  scope = 'i am just a local'
  const fun =() => {
    return scope
  }
  console.log(fun())
}

functionScope()