import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

function PostDetail() {
const {id} = useParams();
const [post, setPost] = useState(null);
const [loading, setLoading] = useState(true);
const [error, setError] = useState(null);

    useEffect(()=>  {
        const getResult = async () => {
            try {
            const result = await fetch((`http://localhost:8080/api/posts/${id}`));

            if(!result.ok) {
                throw new Error(`서버오류: ${result.status}`)
            }
            const data = await result.json();   // json -> js object로 변환
            setPost(data);
        }  catch (err) {
            setError(err.message);
        }  finally {
            setLoading(false);
        }
        }

        getResult();
    }, []);


    if(loading) return <p>로딩중 ...</p>;
    if(error) return <p>에러발생: {error}</p>

    return(
        <>
            <p>{post.title}</p>
            <p>{post.content}</p>
            <button>수정</button>
            <button>삭제</button>
        </>
    )
}

export default PostDetail;