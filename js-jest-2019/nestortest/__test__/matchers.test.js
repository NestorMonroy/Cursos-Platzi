describe("Comparadores comunes", () => {
  const user = {
    name: "nestor",
    lastname: "monroy",
  };
  const user2 = {
    name: "nestor2",
    lastname: "monroy2",
  };
  test("igualdad de elementos", () => {
    expect(user).toEqual(user);
  });
  test("No son exactamente iguales", () => {
    expect(user).not.toEqual(user2);
  });
});
