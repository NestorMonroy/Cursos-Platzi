import React from "react";
import { mount, shallow } from "enzyme";
import ProviderMock from "../../__mocks__/ProviderMock";
import Header from "../../components/Header";

// mount --> Cuando necesitas el DOM
// shallow --> Solo necesitas algo particular del componente. No ocupas todo el DOM
describe("<Header />", () => {
  test("Render del componente Header", () => {
    const header = shallow(
      <ProviderMock>
        <Header />
      </ProviderMock>
    );
    expect(header.length).toEqual(1);
  });
  test("Render del Titulo", () => {
    const header = mount(
      <ProviderMock>
        <Header />
      </ProviderMock>
    );
    expect(header.find(".Header-title").text()).toEqual("Store");
  });
});
