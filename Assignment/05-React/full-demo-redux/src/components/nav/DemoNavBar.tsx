import React, { useState } from "react";
import {
  Collapse,
  Nav,
  Navbar,
  NavbarToggler,
  NavItem,
  NavLink,
} from "reactstrap";

interface IProps {}

export const DemoNavBar: React.FC<IProps> = (props: IProps) => {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  return (
    <div>
      <Navbar color="dark" dark expand="md">
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="mr-auto" navbar>
            <NavItem>
              <NavLink href="/">Home</NavLink>
            </NavItem>
            <NavItem>
                <NavLink href = "/punkin">Punkins</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href= "/list">Lists</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href= "/login">Login</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href= "/pokes">Pokemon</NavLink>
            </NavItem>
            <NavItem className="ml-auto">
              <NavLink onClick={() => localStorage.setItem("username","")} href="/">Logout</NavLink>
            </NavItem>
          </Nav>
        </Collapse>
      </Navbar>
    </div>
  );
};