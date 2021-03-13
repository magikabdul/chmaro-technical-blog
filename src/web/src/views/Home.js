import React from 'react';
import Helmet from "react-helmet";
import {Layout} from "./Layout";
import {ArticleCard} from "../components";
import {Grid} from "@material-ui/core";
import {useQuery} from "react-query";
import ARTICLE_SERVICE from "../services/article-service";

export function Home() {
    const {data, isSuccess} = useQuery("articles", ARTICLE_SERVICE.getAllArticles);

    console.log(data)
    return (
        <React.Fragment>
            <Helmet>
                <title>Blog - recent posts</title>
            </Helmet>
            <Layout>
                <Grid container spacing={3}>
                    {isSuccess && <ArticleCard article={data}/> }
                </Grid>
            </Layout>
        </React.Fragment>
    )
}