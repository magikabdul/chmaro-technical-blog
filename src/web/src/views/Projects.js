import React from 'react';

import {Layout} from "./Layout";
import {Helmet} from "react-helmet";

export function Projects() {
    return (
        <React.Fragment>
            <Helmet>
                <title>My projects</title>
            </Helmet>
            <Layout>projects view</Layout>
        </React.Fragment>
    )
}