import React from 'react';
import {Box, Card, CardContent, Chip, makeStyles, Typography} from "@material-ui/core";
import DotIcon from '@material-ui/icons/FiberManualRecord';

const useStyles = makeStyles((theme) => ({
    root: {
        margin: theme.spacing(2),
    },

    card: {
        width: "100%",

    },

    tag: {
        padding: theme.spacing(1),
        margin: "10px 10px 0 0",
        color: "#888888",
    }
}))

function tagsArrays(tags, classes) {
    return (
        <Box>
            {tags.map(tag => <Chip key={tag.id} className={classes} icon={<DotIcon fontSize={"small"} style={{color: "green"}}/>}
                                   label={tag.name}/>)}
        </Box>
    )
};

export function ProjectCard({project: {title, description, tags}}) {
    const classes = useStyles();

    return (
        <Box className={classes.root}>
            <Card className={classes.card}>
                <CardContent>
                    <Typography component="h5" variant="h5">
                        {title}
                    </Typography>
                    <Typography variant="subtitle1" color="textSecondary">
                        {description}
                    </Typography>
                    {tagsArrays(tags, classes.tag)}
                </CardContent>
            </Card>
        </Box>
    )
}