import React from "react";
import { mount } from "enzyme";
import { create } from 'react-test-renderer';
import Footer from "../../components/Footer";

describe("<Footer />", () => {
  const footer = mount(<Footer />);

  test("Render of Footer Component", () => {
    expect(footer.length).toEqual(1);
  });

  test("Render of Footer Title", () => {
    expect(footer.find(".Footer-title").text()).toEqual("Store");
  });
});

describe("Footer Snapshot", () => {
  test("Comprobar la UI del componente Footer", () => {
    const footer = create(<Footer />);
    expect(footer.toJSON()).toMatchSnapshot();
  });
});

describe('Footer Snapshot', () => {
  test('Comprobar la UI del componente Footer', () => {
    const footer = create(<Footer />);
    expect(footer.toJSON()).toMatchSnapshot();
  });
});
