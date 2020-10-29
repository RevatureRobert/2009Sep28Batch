/**
 * This is the interface for our table. We export it here for
 * modularity and for separation of concerns.
 */

export interface IPunkin {
  name: string;
  description: string;
  size: number;
  pretty: boolean;
}
