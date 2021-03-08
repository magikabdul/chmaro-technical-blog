import React from 'react';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {ThemeProvider} from '@material-ui/core/styles';
import {Box, CssBaseline} from '@material-ui/core'
import {makeStyles} from "@material-ui/core/styles";

import {routes} from "../routes/routes";
import theme from "../theme/theme";
import {Footer, Header} from "../components";
import {About, Home, Projects} from "../views";

const useStyles = makeStyles((theme) => ({
    root: {
        margin: "auto",
        width: "60%",

        [theme.breakpoints.down("lg")]: {
            width: "80%",
        },

        [theme.breakpoints.down("md")]: {
            width: "95%",
        },

        [theme.breakpoints.down("xs")]: {
            width: "100%",
        },
    }
}))

function App() {
    const classes = useStyles();

    return (
        <React.Fragment>
            <CssBaseline/>
            <ThemeProvider theme={theme}>
                <Box className={classes.root}>
                    <BrowserRouter>
                        <Header/>
                        <Switch>
                            <Route path={routes.home} exact component={Home}/>
                            <Route path={routes.about} exact component={About}/>
                            <Route path={routes.projects} exact component={Projects}/>
                        </Switch>

                    </BrowserRouter>
                    <Footer/>
                </Box>
            </ThemeProvider>
        </React.Fragment>
    )
}

export default App;