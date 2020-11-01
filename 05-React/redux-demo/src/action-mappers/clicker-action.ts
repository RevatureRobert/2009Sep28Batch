export const ClickerTypes = {
  CLICKED: "CLICKED",
};

export const incrementClicks = (clicks: number) => {
  return {
    type: ClickerTypes.CLICKED,
    payload: {
      numOfClicks: clicks,
    },
  };
};
