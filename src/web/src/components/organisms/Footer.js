import React from 'react';
import {makeStyles, Typography} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
    root: {
        display: "flex",
        justifyContent: "center",
        alignItems: "center",

        background: "#3f51b5",
        padding: theme.spacing(2)
    },

    info: {
        color: "#f5f5f5"
    },
}))

export function Footer() {
    const classes = useStyles();

    return(
        <footer className={classes.root}>
            <Typography className={classes.info}>&copy; {new Date().getFullYear()}</Typography>
        </footer>
    )
}