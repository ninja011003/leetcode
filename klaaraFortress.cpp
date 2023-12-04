//Klaara fortress solution

#include<bits/stdc++.h>
using namespace std;


int fn(vector<vector<int>>& grid) {
        if(grid[0][0]==1)return -1;


        int n=grid.size(),m=grid[0].size();

        vector<vector<int>>dp(n+1,vector<int>(m+1,-1));

        queue<vector<int>>q;
        q.push({0,0,1});


        dp[0][0]=1;

        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};


        while(q.size()){
            vector<int>c=q.front();
            q.pop();

            int x=c[0],y=c[1];

            for(int k=0;k<4;k++){
                int nx=x+dx[k],ny=y+dy[k];

                if(nx>=0 and nx<n and ny>=0 and ny<m and grid[nx][ny]==0 and dp[nx][ny]==-1){
                    dp[nx][ny]=c[2]+1;
                    q.push({nx,ny,c[2]+1});
                }
            }
        }

        return dp[n-1][m-1];

        
        
    }

int main(){

    int n,m;
    cin>>n>>m;

    vector<vector<int>>mat(n,vector<int>(m));

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>mat[i][j];
        }
    }
    int mx=fn(mat);
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if((i==0 and j==0) or  (i==n-1 and j==m-1)){
                continue;
            }

            if(mat[i][j]==0){
                mat[i][j]=1;
                int ans=fn(mat);
                mx=max(ans,mx);
                mat[i][j]=0;
            }
        }
    }

    cout<<mx;
}