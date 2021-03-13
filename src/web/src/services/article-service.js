import {BASE_URL} from "../constants/app-data";

const ARTICLE_SERVICE = (function () {

    const getAllArticles = async () => {
        const res = await fetch(`${BASE_URL}/articles/3`);
        return res.json();
    }

    const getCoverById = async () => {
        const res = await fetch(`${BASE_URL}//articles/cover/3`);
        return res.blob();
    }

    return {
        getAllArticles,
        getCoverById
    }
})();

export default ARTICLE_SERVICE;