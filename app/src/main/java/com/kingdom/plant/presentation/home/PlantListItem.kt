package com.kingdom.plant.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kingdom.plant.domain.model.PlantListItem
import com.kingdom.plant.presentation.ui.theme.greenDark

@Composable
fun PlantListItem(
    data: PlantListItem
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .shadow(
                elevation = 8.dp,
                clip = true
            )
            .background(
                color = androidx.compose.ui.graphics.Color.White,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data.imageUrl)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = "Loaded image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            Text(
                text = data.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = greenDark,
                modifier = Modifier
                    .padding(horizontal = 18.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            Text(
                text = data.scientificName,
                fontSize = 14.sp,
                color = greenDark,
                modifier = Modifier
                    .padding(horizontal = 18.dp)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            Text(
                text = "Family : " + data.family,
                fontStyle = FontStyle.Italic,
                fontSize = 13.sp,
                color = greenDark,
                modifier = Modifier
                    .padding(horizontal = 18.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            )
            Text(
                text = "Genus : " + data.genus,
                fontStyle = FontStyle.Italic,
                fontSize = 13.sp,
                color = greenDark,
                modifier = Modifier
                    .padding(horizontal = 18.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
            )
        }

    }


}