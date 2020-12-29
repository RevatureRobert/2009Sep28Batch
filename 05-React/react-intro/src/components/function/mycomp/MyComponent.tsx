import React, { useState } from 'react';

export const MyComponent: React.FC<any> = () => {
    const [users, setUsers] = useState(
        ['Abby', 'Billly', 'Cathy']
    )
    
    const renderUsers = () => {
        return users.map((user) => <li>{user}</li>);
    };

    return (
        <div>
            <ol>
                {renderUsers()}
            </ol>
        </div>
    )
}