import React from 'react';
import {makeStyles} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
    root: {
        padding: theme.spacing(2),
        background: "#eee",
    },
}))

export function Layout({children}) {
    const classes = useStyles();

    return (
        <main className={classes.root}>{children}</main>
    )
}