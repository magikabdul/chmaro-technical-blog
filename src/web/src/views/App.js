import React from 'react';
import {ThemeProvider} from '@material-ui/core/styles';
import {CssBaseline, Typography} from '@material-ui/core'

import theme from "../theme/theme";

function App() {
    return (
        <React.Fragment>
            <CssBaseline/>
            <ThemeProvider theme={theme}>
                <Typography>hello</Typography>
            </ThemeProvider>
        </React.Fragment>
    )
}

export default App;