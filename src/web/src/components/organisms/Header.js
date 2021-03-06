import React from 'react';
import {Link} from 'react-router-dom';
import {AppBar, Button, makeStyles, Toolbar} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
    root: {
        marginLeft: theme.spacing(10),
    },

    link: {
        textDecoration: "none",
        color: '#f5f5f5',
    },

    menuItem: {
        textTransform: "uppercase",
        padding: "0 16",
        marginRight: theme.spacing(4),
        fontSize: 14,
    },
}))

export function Header() {
    const classes = useStyles();

    return(
        <AppBar position={"relative"}>
            <Toolbar className={classes.root}>
                <Link className={classes.link} to={"/"}>
                    <Button className={classes.menuItem} color={"inherit"}>blog</Button>
                </Link>

                <Link className={classes.link} to={"/about"}>
                    <Button className={classes.menuItem} color={"inherit"}>about</Button>
                </Link>
            </Toolbar>
        </AppBar>
    )
}
