package Battle;

class UserSolution
{
	static class Soldier {
		int mID;
		int mScore;

		public Soldier (int mID, int mScore) {
			this.mID = mID;
			this.mScore = mScore;
		}
	}

	static Soldier[][] s;
	static int[] t;

	public void init()
	{
		s = new Soldier[5][100001];
		t = new int[5];
	}

	public void hire(int mID, int mTeam, int mScore)
	{
		s[mTeam-1][++t[mTeam-1]] = new Soldier(mID, mScore);
		upHeap(mTeam, t[mTeam-1]);
	}

	public void upHeap(int mTeam, int idx) {
		while (idx > 1) {
			if (s[mTeam-1][idx].mScore > s[mTeam-1][idx/2].mScore) {
				Soldier tmp = s[mTeam-1][idx];
				s[mTeam-1][idx] = s[mTeam-1][idx/2];
				s[mTeam-1][idx/2] = tmp;
				idx = idx/2;
			} else {
				return;
			}
		}
	}

	public void downHeap(int mTeam, int idx) {
		while (idx*2 <= t[mTeam-1]) {
			if (s[mTeam-1][idx].mScore < s[mTeam-1][idx*2].mScore) {
				if (idx*2+1 <= t[mTeam-1] && s[mTeam-1][idx].mScore < s[mTeam-1][idx*2+1].mScore) {
					if (s[mTeam-1][idx*2].mScore < s[mTeam-1][idx*2+1].mScore) {
						Soldier tmp = s[mTeam-1][idx*2+1];
						s[mTeam-1][idx*2+1] = s[mTeam-1][idx];
						s[mTeam-1][idx] = tmp;
						idx = idx*2+1;
					} else {
						Soldier tmp = s[mTeam-1][idx*2];
						s[mTeam-1][idx*2] = s[mTeam-1][idx];
						s[mTeam-1][idx] = tmp;
						idx = idx*2;
					}
				} else {
					Soldier tmp = s[mTeam-1][idx*2];
					s[mTeam-1][idx*2] = s[mTeam-1][idx];
					s[mTeam-1][idx] = tmp;
					idx = idx*2;
				}
			} else if (idx*2+1 <= t[mTeam-1] && s[mTeam-1][idx].mScore < s[mTeam-1][idx*2+1].mScore) {
				Soldier tmp = s[mTeam-1][idx*2+1];
				s[mTeam-1][idx*2+1] = s[mTeam-1][idx];
				s[mTeam-1][idx] = tmp;
				idx = idx*2+1;
			} else {
				return;
			}
		}
	}

	public void fire(int mID)
	{
		for (int i = 0; i < 5; ++i) {
			for (int j = 1; j <= t[i]; ++j) {
				if (s[i][j].mID == mID) {
					s[i][j] = s[i][t[i]--];
					upHeap(i+1, j);
					downHeap(i+1, j);
					return;
				}
			}
		}
	}

	public void updateSoldier(int mID, int mScore)
	{
		for (int i = 0; i < 5; ++i) {
			for (int j = 1; j <= t[i]; ++j) {
				if (s[i][j].mID == mID) {
					s[i][j].mScore = mScore;
					upHeap(i+1, j);
					downHeap(i+1, j);
					return;
				}
			}
		}
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		for (int i = 1; i <= t[mTeam-1]; ++i) {
			if (s[mTeam-1][i].mScore + mChangeScore > 5)
				s[mTeam-1][i].mScore = 5;
			else if (s[mTeam-1][i].mScore + mChangeScore < 1)
				s[mTeam-1][i].mScore = 1;
			else
				s[mTeam-1][i].mScore += mChangeScore;
		}
	}

	public int bestSoldier(int mTeam)
	{
//		System.out.println(s[mTeam-1][1].mID + ", " + s[mTeam-1][1].mScore);
//		if (t[mTeam-1] >= 2)
//			System.out.println(s[mTeam-1][2].mID + ", " + s[mTeam-1][2].mScore);
//		if (t[mTeam-1] >= 3)
//			System.out.println(s[mTeam-1][3].mID + ", " + s[mTeam-1][3].mScore);
		if (t[mTeam-1] >= 2 && s[mTeam-1][1].mScore == s[mTeam-1][2].mScore) {
			if (t[mTeam-1] >= 3 && s[mTeam-1][1].mScore == s[mTeam-1][3].mScore) {
				if (s[mTeam-1][2].mID > s[mTeam-1][3].mID) {
					if (s[mTeam-1][1].mID > s[mTeam-1][2].mID)
						return s[mTeam-1][1].mID;
					return s[mTeam-1][2].mID;
				} else {
					if (s[mTeam-1][1].mID > s[mTeam-1][3].mID)
						return s[mTeam-1][1].mID;
					return s[mTeam-1][3].mID;
				}
			}
			if (s[mTeam-1][1].mID > s[mTeam-1][2].mID)
				return s[mTeam-1][1].mID;
			return s[mTeam-1][2].mID;
		}
		return s[mTeam-1][1].mID;
	}
}
