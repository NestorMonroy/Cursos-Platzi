const text = "Hola Nestor";

test("Debe contener un texto", () => {
  expect(text).toMatch(/Nestor/);
});
