import React from 'react';
import './header.css';
import {Link} from "react-router-dom";

const Header = ({search,filterMovies}) => {
    return (
        <div className='header'>
            <div className='header-title'>
                <span>Travel</span>
                <span className='halfBlue'>Points</span>
            </div>
             <div className='logout'>
                <Link className='link' to='/'>
                      Logout
                </Link>
             </div>

        </div>
    );
};

export default Header;