import React from 'react';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {ThemeProvider} from '@material-ui/core/styles';
import {CssBaseline} from '@material-ui/core'

import {routes} from "../routes/routes";
import theme from "../theme/theme";
import {Footer, Header} from "../components";
import {About, Home, Projects} from "../views";

function App() {
    return (
        <React.Fragment>
            <CssBaseline/>
            <ThemeProvider theme={theme}>
                <BrowserRouter>
                    <Header/>
                    <Switch>
                        <Route path={routes.home} exact component={Home}/>
                        <Route path={routes.about} exact component={About}/>
                        <Route path={routes.projects} exact component={Projects}/>
                    </Switch>

                </BrowserRouter>
                <Footer/>
            </ThemeProvider>
        </React.Fragment>
    )
}

export default App;