/**
 * This is the interface for our table. We export it here for
 * modularity and for separation of concerns.
 */

export interface IPunkin {
  name: string;
  description: string;
  size: number;
  pretty: boolean;
  carving?: string;// quesiton mark makes this field OPTIONAL
}

/*
interface jsIPunkin{
  name: React.ReactPropTypes
} // Validating properties: we're doing this with TypeScript...
*/

/**
 * Specialization in TypeScript
 *    
 */