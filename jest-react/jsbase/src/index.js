const cities = ["Ciudad de México", "Bogotá", "Lima", "Buenos Aires"];

const randomStrings = () => {
  return cities[Math.floor(Math.random() * cities.length)];
};

module.exports = randomStrings;
