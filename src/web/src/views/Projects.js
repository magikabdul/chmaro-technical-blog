import React from 'react';
import {Layout} from "./Layout";
import {Helmet} from "react-helmet";
import {useQuery} from 'react-query';

import PROJECT_SERVICE from "../services/project-service";
import {ProjectCard} from "../components";

export function Projects() {
    const {data, status} = useQuery('projects', PROJECT_SERVICE.getAllProjects);

    return (
        <React.Fragment>
            <Helmet>
                <title>My projects</title>
            </Helmet>
            <Layout>
                {status === "success" && data.map(project => <ProjectCard key={project.id} project={project}/> )}
            </Layout>
        </React.Fragment>
    )
}