import React from 'react';
import {Layout} from "./Layout";
import Helmet from "react-helmet";

export function About() {
    return (
        <React.Fragment>
            <Helmet>
                <title>About author</title>
            </Helmet>
            <Layout>about view</Layout>
        </React.Fragment>
    )
}