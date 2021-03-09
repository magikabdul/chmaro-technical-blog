import React from 'react';
import Helmet from "react-helmet";
import {Layout} from "./Layout";

export function Home() {
    return (
        <React.Fragment>
            <Helmet>
                <title>Blog - recent posts</title>
            </Helmet>
            <Layout>home view</Layout>
        </React.Fragment>
    )
}