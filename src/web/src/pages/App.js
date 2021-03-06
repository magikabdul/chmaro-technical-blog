import React from 'react';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {ThemeProvider} from '@material-ui/core/styles';
import {CssBaseline} from '@material-ui/core'

import theme from "../theme/theme";
import {Footer, Header} from "../components";
import {About, Home} from "../views";

function App() {
    return (
        <React.Fragment>
            <CssBaseline/>
            <ThemeProvider theme={theme}>
                <BrowserRouter>
                    <Header/>
                    <Switch>
                        <Route path={"/"} exact component={Home}/>
                        <Route path={"/about"} exact component={About}/>
                    </Switch>

                </BrowserRouter>
                <Footer/>
            </ThemeProvider>
        </React.Fragment>
    )
}

export default App;