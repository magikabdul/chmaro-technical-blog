import React from 'react';
import {Card, CardContent, Grid, makeStyles, Typography} from "@material-ui/core";
import ARTICLE_SERVICE from "../../services/article-service";
import {useQuery} from "react-query";

const useStyle = makeStyles((theme) => ({
    root: {
        borderRadius: 10,
    },

    media: {
        height: 100,
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center",
    },

    box: {
        paddingBottom: 0,
    },

    date: {
        fontWeight: "bold",
        fontSize: 14,
        color: "#a0a0a0",
    },

    title: {},

    description: {}
}))

export function ArticleCard({
                                article: {
                                    title = "missing title",
                                    description = "no description provided",
                                    createdAt = "00-00-00",
                                    coverId
                                }
                            }) {

    const date = createdAt.slice(0, 10);

    const {data, isSuccess} = useQuery('cover', ARTICLE_SERVICE.getCoverById);
    const coverImg = URL.createObjectURL(data)

    const classes = useStyle();

    return (
        <Grid item xs={12} sm={6} md={4}>
            <Card className={classes.root} elevation={10}>
                {isSuccess && <div className={classes.media} style={{backgroundImage: `url(${coverImg})`}}/>}
                <CardContent className={classes.box}>
                    <Typography className={classes.date}>{date}</Typography>
                </CardContent>

                <CardContent>
                    <Typography gutterBottom variant="h5" component="h2">{title}</Typography>
                    <Typography variant="body2" color="textSecondary" component="p">{description}</Typography>
                </CardContent>
            </Card>
        </Grid>
    )
}