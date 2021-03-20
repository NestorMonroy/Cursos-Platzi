const text = "Hola Nestor";

test("Debe contener un texto", () => {
  expect(text).toMatch(/Nestor/);
});

const fruits = ["manzana", "pera", "banana", "fresa"];

// Test arrays
test("It should has manzana", () => {
  expect(fruits).toContain("manzana");
});

// Test numbers
test("It should be greater than", () => {
  expect(10).toBeGreaterThan(9);
});

// Test Booleans
test("It should be true", () => {
  expect(true).toBeTruthy();
});

// Reverse strings function
const reverseString = (str, cb) => {
  cb(str.split("").reverse().join(""));
};

// Test callbacks
test("The callback should return a reversed word", () => {
  reverseString("Hola", (str) => {
    expect(str).toBe("aloH");
  });
});

// Reverse strings function
const reverseString2 = (str) => {
  return new Promise((resolve, reject) => {
    if (!str) {
      reject(Error("Error"));
    }

    resolve(str.split("").reverse().join(""));
  });
};

test("Probando una promesa", () => {
  reverseString2("Hola").then((string) => {
    expect(string).toBe("aloH");
  });
});

test("Probando async/await", async () => {
  /* const string = await reverseString2('Hola'); */
  expect(await reverseString2("Hola")).toBe("aloH");
});
