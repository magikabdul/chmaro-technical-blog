import {BASE_URL} from "../constants/app-data";

const PROJECT_SERVICE = (function () {
    const URL = `${BASE_URL}/projects`;

    const getAllProjects = async () => {
        const res = await fetch(URL);
        return res.json();
    }

    return {
        getAllProjects,
    }
})();

export default PROJECT_SERVICE;