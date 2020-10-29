export const ClickTypes = {
  CLICKED: "CLICKED",
};

export const incrementClicks = (clicks: number) => {
  return {
    type: ClickTypes.CLICKED,
    payload: {
      numOfClicks: clicks,
    },
  };
};
