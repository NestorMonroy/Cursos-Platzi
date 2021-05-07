const person = () => {
  let name = "Name";

  return {
    get name() {
      return name;
    },

    set name(value) {
      name = value;
    },
  };
};

const newPerson = person();
console.log(newPerson.name);
newPerson.name = "Nestor";
console.log(newPerson.name);
