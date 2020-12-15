import React, { Component } from "react";
import header from "../images/platziconf-logo.svg";
import Badge from "../components/Badge";
import BadgeFrom from "../components/BadgeForm";
import PageLoading from "../components/PageLoading";
import "./styles/BadgeEdit.css";

import api from "../api";

class BadgeEdit extends Component {
  state = {
    loading: true,
    error: null,
    form: {
      firstName: "",
      lastName: "",
      jobTitle: "Designer",
      twitter: "",
      email: "",
    },
  };

  componentDidMount() {
    this.fetchData();
  }

  fetchData = async (e) => {
    this.setState({ loading: true, error: null });

    try {
      const data = await api.badges.read(this.props.match.params.badgeId);
      this.setState({ loading: false, form: data });
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };
  handleChange = (e) => {
    // const nextForm = this.state.form;
    // nextForm[e.target.name] = e.target.value;

    this.setState({
      form: {
        ...this.state.form,
        [e.target.name]: e.target.value,
      },
    });
  };

  handleSubmit = async (e) => {
    e.preventDefault();
    this.setState({ loading: true, error: null });
    try {
      await api.badges.update(this.props.match.params.badgeId, this.state.form);
      this.setState({ loading: false });
      this.props.history.push("/badges");
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };

  render() {
    if (this.state.loading) {
      return <PageLoading />;
    }
    return (
      <React.Fragment>
        <div className="BadgeEdit__hero">
          <img
            className="BadgeEdit__hero-image img-fluid"
            src={header}
            alt="Logo"
          />
        </div>
        <div className="container">
          <div className="row">
            <div className="col-6">
              <Badge
                firstName={this.state.form.firstName || "FIRST_NAME"}
                lastName={this.state.form.lastName || "LAST_NAME"}
                jotTitle={this.state.form.jobTitle || "JOB_TIT"}
                twitter={this.state.form.twitter || "TWITTER"}
                email={this.state.form.email || "EMAIL"}
                avatarUrl="https://www.gravatar.com/avatar?d=identicon"
              />
            </div>
            <div className="col-6">
              <h1>Edit</h1>

              <BadgeFrom
                onChange={this.handleChange}
                onSubmit={this.handleSubmit}
                formValues={this.state.form}
                error={this.state.error}
              />
            </div>
          </div>
        </div>
      </React.Fragment>
    );
  }
}

export default BadgeEdit;
